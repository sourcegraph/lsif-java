package com.airbnb.epoxy;

import android.widget.CompoundButton;
//     ^^^^^^^ reference android/
//             ^^^^^^ reference android/widget/
//                    ^^^^^^^^^^^^^^ reference android/widget/CompoundButton#
import android.widget.CompoundButton.OnCheckedChangeListener;
//     ^^^^^^^ reference android/
//             ^^^^^^ reference android/widget/
//                    ^^^^^^^^^^^^^^ reference android/widget/CompoundButton/
//                                   ^^^^^^^^^^^^^^^^^^^^^^^ reference android/widget/CompoundButton/OnCheckedChangeListener#

import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

/**
 * Used in the generated models to transform normal checked change listener to model
 * checked change.
 */
public class WrappedEpoxyModelCheckedChangeListener<T extends EpoxyModel<?>, V>
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
//                                                  ^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                           ^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
    implements OnCheckedChangeListener {
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference _root_/

  private final OnModelCheckedChangeListener<T, V> originalCheckedChangeListener;
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                           ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                              ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.

  public WrappedEpoxyModelCheckedChangeListener(
//       ^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#`<init>`().
      OnModelCheckedChangeListener<T, V> checkedListener
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                 ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                    ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                       ^^^^^^^^^^^^^^^ definition local0
  ) {
    if (checkedListener == null) {
//      ^^^^^^^^^^^^^^^ reference local0
      throw new IllegalArgumentException("Checked change listener cannot be null");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
    }

    this.originalCheckedChangeListener = checkedListener;
//  ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#this.
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^^^^^^^^^^ reference local0
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onCheckedChanged(CompoundButton button, boolean isChecked) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
//                             ^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local1
//                                                            ^^^^^^^^^ definition local2
    EpoxyViewHolder epoxyHolder = ListenersUtils.getEpoxyHolderForChildView(button);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                  ^^^^^^^^^^^ definition local3
//                                ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ListenersUtils#
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ListenersUtils#getEpoxyHolderForChildView().
//                                                                          ^^^^^^ reference local1
    if (epoxyHolder == null) {
//      ^^^^^^^^^^^ reference local3
      // Initial binding can trigger the checked changed listener when the checked value is set.
      // The view is not attached at this point so the holder can't be looked up, and in any case
      // it is generally better to not trigger a callback for the binding anyway, since it isn't
      // a user action.
      //
      // https://github.com/airbnb/epoxy/issues/797
      return;
    }

    final int adapterPosition = epoxyHolder.getAdapterPosition();
//            ^^^^^^^^^^^^^^^ definition local4
//                              ^^^^^^^^^^^ reference local3
//                                          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    if (adapterPosition != RecyclerView.NO_POSITION) {
//      ^^^^^^^^^^^^^^^ reference local4
//                         ^^^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^ reference NO_POSITION#
      originalCheckedChangeListener
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
          .onChecked((T) epoxyHolder.getModel(), (V) epoxyHolder.objectToBind(), button,
//         ^^^^^^^^^ reference com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//                    ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                       ^^^^^^^^^^^ reference local3
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                ^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                   ^^^^^^^^^^^ reference local3
//                                                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                                               ^^^^^^ reference local1
          isChecked, adapterPosition);
//        ^^^^^^^^^ reference local2
//                   ^^^^^^^^^^^^^^^ reference local4
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#equals().
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local5
    if (this == o) {
//      ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#this.
//              ^ reference local5
      return true;
    }
    if (!(o instanceof WrappedEpoxyModelCheckedChangeListener)) {
//        ^ reference local5
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
      return false;
    }

    WrappedEpoxyModelCheckedChangeListener<?, ?>
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
        that = (WrappedEpoxyModelCheckedChangeListener<?, ?>) o;
//      ^^^^ definition local6
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
//                                                            ^ reference local5

    return originalCheckedChangeListener.equals(that.originalCheckedChangeListener);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^ reference java/lang/Object#equals().
//                                              ^^^^ reference local6
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#hashCode().
    return originalCheckedChangeListener.hashCode();
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^^^ reference java/lang/Object#hashCode().
  }
}
