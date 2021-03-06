package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.lang.annotation.Target;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^ reference java/lang/annotation/Target#

/**
 * This can be used to annotate methods inside classes with a {@link ModelView} annotation. Methods
 * with this annotation will be called when visibility part of the view change.
 * <p>
 * Annotated methods should follow this signature :
 * `@OnVisibilityChanged
 *  public void method(
 *    float percentVisibleHeight, float percentVisibleWidth: Float,
 *    int visibleHeight, int visibleWidth
 *  )`
 * <p>
 * The equivalent methods on the model is {@link com.airbnb.epoxy.EpoxyModel#onVisibilityChanged}
 * <p>
 * @see OnModelVisibilityChangedListener
 */
@Target(ElementType.METHOD)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^^^ reference java/lang/annotation/ElementType#METHOD.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface OnVisibilityChanged {
//                ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnVisibilityChanged#
}
