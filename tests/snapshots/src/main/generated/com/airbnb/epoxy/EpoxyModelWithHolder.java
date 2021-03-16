package com.airbnb.epoxy;

import android.view.ViewParent;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^^ reference android/view/ViewParent#

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^ reference androidx/annotation/FloatRange#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Px;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#

/**
 * A version of {@link com.airbnb.epoxy.EpoxyModel} that allows you to use a view holder pattern
 * instead of a specific view when binding to your model.
 */
public abstract class EpoxyModelWithHolder<T extends EpoxyHolder> extends EpoxyModel<T> {
//                    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#
//                                         ^ definition com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyHolder#
//                                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]

  public EpoxyModelWithHolder() {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`().
  }

  public EpoxyModelWithHolder(long id) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(+1).
//                                 ^^ definition local0
    super(id);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModel#`<init>`().
//        ^^ reference local0
  }

  /** This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. */
  protected abstract T createNewHolder(@NonNull ViewParent parent);
//                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                     ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^ definition local1

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind().
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local2
    super.bind(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^^^ reference local2
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder, @NonNull List<Object> payloads) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local3
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^ reference java/util/List#
//                                                  ^^^^^^ reference java/lang/Object#
//                                                          ^^^^^^^^ definition local4
    super.bind(holder, payloads);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+1).
//             ^^^^^^ reference local3
//                     ^^^^^^^^ reference local4
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local5
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^^^^^^^^^^^^^^^^ definition local6
    super.bind(holder, previouslyBoundModel);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+2).
//             ^^^^^^ reference local5
//                     ^^^^^^^^^^^^^^^^^^^^ reference local6
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void unbind(@NonNull T holder) {
//            ^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#unbind().
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                              ^^^^^^ definition local7
    super.unbind(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^^^ reference local7
  }


  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onVisibilityStateChanged(@Visibility int visibilityState, @NonNull T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#
//                                                     ^^^^^^^^^^^^^^^ definition local8
//                                                                       ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                               ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                                                                 ^^^^^^ definition local9
    super.onVisibilityStateChanged(visibilityState, holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                 ^^^^^^^^^^^^^^^ reference local8
//                                                  ^^^^^^ reference local9
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onVisibilityChanged(
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                          ^^ reference androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local10
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                          ^^ reference androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local11
      @Px int visibleHeight, @Px int visibleWidth,
//     ^^ reference androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local12
//                            ^^ reference androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local13
      @NonNull T holder) {
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//               ^^^^^^ definition local14
    super.onVisibilityChanged(
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
        percentVisibleHeight, percentVisibleWidth,
//      ^^^^^^^^^^^^^^^^^^^^ reference local10
//                            ^^^^^^^^^^^^^^^^^^^ reference local11
        visibleHeight, visibleWidth,
//      ^^^^^^^^^^^^^ reference local12
//                     ^^^^^^^^^^^^ reference local13
        holder);
//      ^^^^^^ reference local14
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean onFailedToRecycleView(T holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onFailedToRecycleView().
//                                     ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local15
    return super.onFailedToRecycleView(holder);
//         ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//               ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^^^^^^ reference local15
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
//                                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                     ^^^^^^ definition local16
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                               ^^^^^^ reference local16
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
//                                     ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local17
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local17
  }
}
