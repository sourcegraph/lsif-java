package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^ reference android/view/ViewGroup#

import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * A model that allows its view to be built programmatically instead of by inflating a layout
 * resource. Just implement {@link #buildView} so the adapter can create a new view for this model
 * when needed.
 * <p>
 * {@link #getViewType()} is used by the adapter to know how to reuse views for this model. This
 * means that all models that return the same type should be able to share the same view, and the
 * view won't be shared with models of any other type.
 * <p>
 * If it is left unimplemented then at runtime a unique view type will be created to use for all
 * models of that class. The generated view type will be negative so that it cannot collide with
 * values from resource files, which are used in normal Epoxy models. If you would like to share
 * the same view between models of different classes you can have those classes return the same view
 * type. A good way to manually create a view type value is by creating an R.id. value in an ids
 * resource file.
 */
public abstract class EpoxyModelWithView<T extends View> extends EpoxyModel<T> {
//                    ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#
//                    ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#`<init>`().
//                                       ^ definition com/airbnb/epoxy/EpoxyModelWithView#[T]
//                                                 ^^^^ reference _root_/
//                                                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^ reference com/airbnb/epoxy/EpoxyModelWithView#[T]

  /**
   * Get the view type associated with this model's view. Any models with the same view type will
   * have views recycled between them.
   *
   * @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemViewType(int)
   */
  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected int getViewType() {
//              ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#getViewType().
    return 0;
  }

  /**
   * Create and return a new instance of a view for this model. If no layout params are set on the
   * returned view then default layout params will be used.
   *
   * @param parent The parent ViewGroup that the returned view will be added to.
   */
  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected abstract T buildView(@NonNull ViewGroup parent);
//                   ^ reference com/airbnb/epoxy/EpoxyModelWithView#[T]
//                     ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#buildView().
//                                ^^^^^^^ reference androidx/annotation/NonNull#
//                                        ^^^^^^^^^ reference _root_/
//                                                  ^^^^^^ definition local0

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected final int getDefaultLayout() {
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#getDefaultLayout().
    throw new UnsupportedOperationException(
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`(+1). 1:83
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#
        "Layout resources are unsupported. Views must be created with `buildView`");
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public EpoxyModel<T> layout(@LayoutRes int layoutRes) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^ reference com/airbnb/epoxy/EpoxyModelWithView#[T]
//                     ^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithView#layout().
//                             ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                           ^^^^^^^^^ definition local1
    throw new UnsupportedOperationException(
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`(+1). 1:83
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#
        "Layout resources are unsupported. Views must be created with `buildView`");
  }
}
