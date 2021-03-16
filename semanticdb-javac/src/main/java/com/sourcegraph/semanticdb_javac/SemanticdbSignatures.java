package com.sourcegraph.semanticdb_javac;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;
import com.sun.tools.javac.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.type.*;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.util.SimpleTypeVisitor8;
import java.util.ArrayList;

public final class SemanticdbSignatures {
    private final GlobalSymbolsCache cache;
    private final LocalSymbolsCache locals;

    public SemanticdbSignatures(GlobalSymbolsCache cache, LocalSymbolsCache locals) {
        this.cache = cache;
        this.locals = locals;
    }

    public Signature generateSignature(Symbol sym) {
        if(sym instanceof Symbol.ClassSymbol) {
            return generateClassSignature((Symbol.ClassSymbol)sym);
        } else if(sym instanceof Symbol.MethodSymbol) {
            return generateMethodSignature((Symbol.MethodSymbol)sym);
        } else if(sym instanceof Symbol.VarSymbol) {
            return generateFieldSignature((Symbol.VarSymbol)sym);
        } else if(sym instanceof Symbol.TypeVariableSymbol) {
            return generateTypeSignature((Symbol.TypeVariableSymbol)sym);
        }
        return null;
    }

    private Signature generateClassSignature(Symbol.ClassSymbol sym) {
        ClassSignature.Builder builder = ClassSignature.newBuilder();

        builder.setTypeParameters(generateScope(sym.getTypeParameters()));

        builder.addParents(generateType(sym.getSuperclass()));
        for (Type iType : sym.getInterfaces()) {
            builder.addParents(generateType(iType));
        }

        Scope.Builder declarations = Scope.newBuilder();
        for(Symbol enclosed : sym.getEnclosedElements()) {
            declarations.addSymlinks(cache.semanticdbSymbol(enclosed, locals));
        }
        builder.setDeclarations(declarations);

        return Signature.newBuilder().setClassSignature(builder).build();
    }

    private Signature generateMethodSignature(Symbol.MethodSymbol sym) {
        MethodSignature.Builder builder = MethodSignature.newBuilder();

        builder.setTypeParameters(generateScope(sym.getTypeParameters()));

        builder.addParameterLists(generateScope(sym.params()));

        builder.setReturnType(generateType(sym.getReturnType()));

        return Signature.newBuilder().setMethodSignature(builder).build();
    }

    private Signature generateFieldSignature(Symbol.VarSymbol sym) {
        return Signature.newBuilder().setValueSignature(ValueSignature.newBuilder().setTpe(generateType(sym.type))).build();
    }

    private Signature generateTypeSignature(Symbol.TypeVariableSymbol sym) {
        TypeSignature.Builder builder = TypeSignature.newBuilder();

        builder.setTypeParameters(generateScope(sym.getTypeParameters()));

        builder.setUpperBound(generateType(sym.type.getUpperBound()));

        return Signature.newBuilder().setTypeSignature(builder).build();
    }

    private <T extends Element> Scope generateScope(List<T> elements) {
        Scope.Builder scope = Scope.newBuilder();
        for (T typeVar : elements) {
            String s = cache.semanticdbSymbol(typeVar, locals);
            scope.addSymlinks(s);
        }
        return scope.build();
    }

    private Semanticdb.Type generateType(TypeMirror mirror) {
        return mirror.accept(new SemanticdbTypeVisitor(cache, locals), null);
    }

    private static class SemanticdbTypeVisitor extends SimpleTypeVisitor8<Semanticdb.Type, Void> {
        private final GlobalSymbolsCache cache;
        private final LocalSymbolsCache locals;

        private SemanticdbTypeVisitor(GlobalSymbolsCache cache, LocalSymbolsCache locals) {
            this.cache = cache;
            this.locals = locals;
        }

        @Override
        public Semanticdb.Type visitDeclared(DeclaredType t, Void unused) {
            ArrayList<Semanticdb.Type> typeParams = new ArrayList<>();
            for(TypeMirror type : t.getTypeArguments()) {
                typeParams.add(super.visit(type));
            }
            return Semanticdb.Type.newBuilder().setTypeRef(
                    TypeRef.newBuilder()
                        .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                        .addAllTypeArguments(typeParams)
            ).build();
            //return super.visitDeclared(t, unused);
        }

        @Override
        public Semanticdb.Type visitArray(ArrayType t, Void unused) {
            return Semanticdb.Type.newBuilder().setTypeRef(
                    TypeRef.newBuilder()
                    .setSymbol("scala/Array#")
                    .addTypeArguments(super.visit(t.getComponentType()))).build();
        }

        @Override
        public Semanticdb.Type visitPrimitive(PrimitiveType t, Void unused) {
            return Semanticdb.Type.newBuilder().setTypeRef(
                TypeRef.newBuilder().setSymbol(primitiveSymbol(t.getKind()))
            ).build();
        }

        /*@Override
        public Semanticdb.Type visitTypeVariable(TypeVariable t, Void unused) {
            return Semanticdb.Type.newBuilder().setTypeRef(
                    TypeSignature.newBuilder().
            ).build();
            //return super.visitTypeVariable(t, unused);
        }*/

        @Override
        public Semanticdb.Type visitIntersection(IntersectionType t, Void unused) {
            ArrayList<Semanticdb.Type> types = new ArrayList<>();
            for(TypeMirror type : t.getBounds()) {
                types.add(super.visit(type));
            }

            return Semanticdb.Type.newBuilder().setIntersectionType(
                    Semanticdb.IntersectionType.newBuilder().addAllTypes(types).build()
            ).build();
        }

        public String primitiveSymbol(TypeKind kind) {
            switch (kind) {
                case BOOLEAN:
                    return "scala/Boolean#";
                case BYTE:
                    return "scala/Byte#";
                case SHORT:
                    return "scala/Short#";
                case INT:
                    return "scala/Int#";
                case LONG:
                    return "scala/Long#";
                case CHAR:
                    return "scala/Char#";
                case FLOAT:
                    return "scala/Float#";
                case DOUBLE:
                    return "scala/Double#";
                case VOID:
                    return "scala/Unit#";
                default:
                    throw new IllegalArgumentException("got " + kind.name());
            }
        }
    }
}
