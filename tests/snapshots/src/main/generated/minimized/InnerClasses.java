package minimized;

public class InnerClasses {
//           ^^^^^^^^^^^^ definition minimized/InnerClasses#

  private final int exampleField;
//                  ^^^^^^^^^^^^ definition minimized/InnerClasses#exampleField.

  public InnerClasses(int exampleField) {
//       ^^^^^^ definition minimized/InnerClasses#`<init>`().
//                        ^^^^^^^^^^^^ definition local0
    this.exampleField = exampleField;
//  ^^^^ reference minimized/InnerClasses#this.
//       ^^^^^^^^^^^^ reference minimized/InnerClasses#exampleField.
//                      ^^^^^^^^^^^^ reference local0
  }

  public enum InnerEnum {
//            ^^^^^^^^^ definition minimized/InnerClasses#InnerEnum#
//            ^^^^^^^^^ definition minimized/InnerClasses#InnerEnum#`<init>`().
    A,
//  ^ definition minimized/InnerClasses#InnerEnum#A.
    B,
//  ^ definition minimized/InnerClasses#InnerEnum#B.
    C
//  ^ definition minimized/InnerClasses#InnerEnum#C.
  }

  public interface InnerInterface<A, B> {
//                 ^^^^^^^^^^^^^^ definition minimized/InnerClasses#InnerInterface#
//                                ^ definition minimized/InnerClasses#InnerInterface#[A]
//                                   ^ definition minimized/InnerClasses#InnerInterface#[B]
    B apply(A a);
//  ^ reference minimized/InnerClasses#InnerInterface#[B]
//    ^^^^^ definition minimized/InnerClasses#InnerInterface#apply().
//          ^ reference minimized/InnerClasses#InnerInterface#[A]
//            ^ definition local1
  }

  public static class InnerStaticClass {
//                    ^^^^^^^^^^^^^^^^ definition minimized/InnerClasses#InnerStaticClass#
//                    ^^^^^^^^^^^^^^^^ definition minimized/InnerClasses#InnerStaticClass#`<init>`().
    public static void innerStaticMethod() {}
//                     ^^^^^^^^^^^^^^^^^ definition minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
  }

  public class InnerClass implements InnerInterface<Integer, Integer> {
//             ^^^^^^^^^^ definition minimized/InnerClasses#InnerClass#
//                                   ^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerInterface#
//                                                  ^^^^^^^ reference java/lang/Integer#
//                                                           ^^^^^^^ reference java/lang/Integer#
    private final int field;
//                    ^^^^^ definition minimized/InnerClasses#InnerClass#field.

    public InnerClass(int field) {
//         ^^^^^^ definition minimized/InnerClasses#InnerClass#`<init>`().
//                        ^^^^^ definition local2
      this.field = field;
//    ^^^^ reference minimized/InnerClasses#InnerClass#this.
//         ^^^^^ reference minimized/InnerClasses#InnerClass#field.
//                 ^^^^^ reference local2
    }

    public void innerMethod() {
//              ^^^^^^^^^^^ definition minimized/InnerClasses#InnerClass#innerMethod().
      System.out.println(field + exampleField);
//    ^^^^^^ reference java/lang/System#
//           ^^^ reference java/lang/System#out.
//               ^^^^^^^ reference java/io/PrintStream#println(+3).
//                       ^^^^^ reference minimized/InnerClasses#InnerClass#field.
//                               ^^^^^^^^^^^^ reference minimized/InnerClasses#exampleField.
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public Integer apply(Integer integer) {
//         ^^^^^^^ reference java/lang/Integer#
//                 ^^^^^ definition minimized/InnerClasses#InnerClass#apply().
//                       ^^^^^^^ reference java/lang/Integer#
//                               ^^^^^^^ definition local3
      return field * integer;
//           ^^^^^ reference minimized/InnerClasses#InnerClass#field.
//                   ^^^^^^^ reference local3
    }
  }

  private static <A, B> B runInnerInterface(InnerInterface<A, B> fn, A a) {
//                      ^ reference minimized/InnerClasses#runInnerInterface().[B]
//                        ^^^^^^^^^^^^^^^^^ definition minimized/InnerClasses#runInnerInterface().
//                                          ^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerInterface#
//                                                         ^ reference minimized/InnerClasses#runInnerInterface().[A]
//                                                            ^ reference minimized/InnerClasses#runInnerInterface().[B]
//                                                               ^^ definition local4
//                                                                   ^ reference minimized/InnerClasses#runInnerInterface().[A]
//                                                                     ^ definition local5
    return fn.apply(a);
//         ^^ reference local4
//            ^^^^^ reference minimized/InnerClasses#InnerInterface#apply().
//                  ^ reference local5
  }

  public static void testEnum(InnerEnum magicEnum) {
//                   ^^^^^^^^ definition minimized/InnerClasses#testEnum().
//                            ^^^^^^^^^ reference minimized/InnerClasses#InnerEnum#
//                                      ^^^^^^^^^ definition local6
    if (System.nanoTime() > System.nanoTime()) {
//      ^^^^^^ reference java/lang/System#
//             ^^^^^^^^ reference java/lang/System#nanoTime().
//                          ^^^^^^ reference java/lang/System#
//                                 ^^^^^^^^ reference java/lang/System#nanoTime().
      magicEnum = InnerEnum.B;
//    ^^^^^^^^^ reference local6
//                ^^^^^^^^^ reference minimized/InnerClasses#InnerEnum#
//                          ^ reference minimized/InnerClasses#InnerEnum#B.
    }
    switch (magicEnum) {
//          ^^^^^^^^^ reference local6
      case B:
//         ^ reference minimized/InnerClasses#InnerEnum#B.
        System.out.println("b");
//      ^^^^^^ reference java/lang/System#
//             ^^^ reference java/lang/System#out.
//                 ^^^^^^^ reference java/io/PrintStream#println(+8).
        break;
      case A:
//         ^ reference minimized/InnerClasses#InnerEnum#A.
        System.out.println("a");
//      ^^^^^^ reference java/lang/System#
//             ^^^ reference java/lang/System#out.
//                 ^^^^^^^ reference java/io/PrintStream#println(+8).
        break;
      default:
        break;
    }
    if (magicEnum == InnerEnum.A) System.out.println("a");
//      ^^^^^^^^^ reference local6
//                   ^^^^^^^^^ reference minimized/InnerClasses#InnerEnum#
//                             ^ reference minimized/InnerClasses#InnerEnum#A.
//                                ^^^^^^ reference java/lang/System#
//                                       ^^^ reference java/lang/System#out.
//                                           ^^^^^^^ reference java/io/PrintStream#println(+8).
    else if (magicEnum == InnerEnum.C) System.out.println("b");
//           ^^^^^^^^^ reference local6
//                        ^^^^^^^^^ reference minimized/InnerClasses#InnerEnum#
//                                  ^ reference minimized/InnerClasses#InnerEnum#C.
//                                     ^^^^^^ reference java/lang/System#
//                                            ^^^ reference java/lang/System#out.
//                                                ^^^^^^^ reference java/io/PrintStream#println(+8).
    else System.out.println("c");
//       ^^^^^^ reference java/lang/System#
//              ^^^ reference java/lang/System#out.
//                  ^^^^^^^ reference java/io/PrintStream#println(+8).
  }

  public static void testAnon() {
//                   ^^^^^^^^ definition minimized/InnerClasses#testAnon().
    InnerInterface<String, String> fn =
//  ^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerInterface#
//                 ^^^^^^ reference java/lang/String#
//                         ^^^^^^ reference java/lang/String#
//                                 ^^ definition local7
        new InnerInterface<String, String>() {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local9 5:9
//          ^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerInterface#
//          ^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerInterface#
//                         ^^^^^^ reference java/lang/String#
//                         ^^^^^^ reference java/lang/String#
//                                 ^^^^^^ reference java/lang/String#
//                                 ^^^^^^ reference java/lang/String#
          @Override
//         ^^^^^^^^ reference java/lang/Override#
          public String apply(String s) {
//               ^^^^^^ reference java/lang/String#
//                      ^^^^^ definition local10
//                            ^^^^^^ reference java/lang/String#
//                                   ^ definition local11
            return s + "b";
//                 ^ reference local11
          }
        };
    System.out.println(fn.apply("a"));
//  ^^^^^^ reference java/lang/System#
//         ^^^ reference java/lang/System#out.
//             ^^^^^^^ reference java/io/PrintStream#println(+8).
//                     ^^ reference local7
//                        ^^^^^ reference minimized/InnerClasses#InnerInterface#apply().
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/InnerClasses#app().
    int a = 42;
//      ^ definition local12
    InnerStaticClass.innerStaticMethod();
//  ^^^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerStaticClass#
//                   ^^^^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerStaticClass#innerStaticMethod().
    InnerClasses innerClasses = new InnerClasses(a);
//  ^^^^^^^^^^^^ reference minimized/InnerClasses#
//               ^^^^^^^^^^^^ definition local13
//                              ^^^^^^^^^^^^^^^^^^^ reference minimized/InnerClasses#`<init>`().
//                                  ^^^^^^^^^^^^ reference minimized/InnerClasses#
//                                               ^ reference local12
    InnerClass innerClass = innerClasses.new InnerClass(a);
//  ^^^^^^^^^^ reference minimized/InnerClasses#InnerClass#
//             ^^^^^^^^^^ definition local14
//                          ^^^^^^^^^^^^ reference local13
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/InnerClasses#InnerClass#`<init>`().
//                                           ^^^^^^^^^^ reference minimized/InnerClasses#InnerClass#
//                                                      ^ reference local12
    innerClass.innerMethod();
//  ^^^^^^^^^^ reference local14
//             ^^^^^^^^^^^ reference minimized/InnerClasses#InnerClass#innerMethod().
    System.out.println(runInnerInterface(innerClass, a));
//  ^^^^^^ reference java/lang/System#
//         ^^^ reference java/lang/System#out.
//             ^^^^^^^ reference java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^^^^^^^ reference minimized/InnerClasses#runInnerInterface().
//                                       ^^^^^^^^^^ reference local14
//                                                   ^ reference local12
    testEnum(InnerEnum.A);
//  ^^^^^^^^ reference minimized/InnerClasses#testEnum().
//           ^^^^^^^^^ reference minimized/InnerClasses#InnerEnum#
//                     ^ reference minimized/InnerClasses#InnerEnum#A.
    testAnon();
//  ^^^^^^^^ reference minimized/InnerClasses#testAnon().
    return "";
  }
}
