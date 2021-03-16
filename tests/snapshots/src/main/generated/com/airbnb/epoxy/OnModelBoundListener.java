package com.airbnb.epoxy;

/** Used to register an onBind callback with a generated model. */
public interface OnModelBoundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelBoundListener#
//                                    ^ definition com/airbnb/epoxy/OnModelBoundListener#[T]
//                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition com/airbnb/epoxy/OnModelBoundListener#[V]
  /**
   * This will be called immediately after a model was bound, with the model and view that were
   * bound together.
   *
   * @param model    The model being bound
   * @param view     The view that is being bound to the model
   * @param position The adapter position of the model
   */
  void onModelBound(T model, V view, int position);
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelBoundListener#onModelBound().
//                  ^ reference com/airbnb/epoxy/OnModelBoundListener#[T]
//                    ^^^^^ definition local0
//                           ^ reference com/airbnb/epoxy/OnModelBoundListener#[V]
//                             ^^^^ definition local1
//                                       ^^^^^^^^ definition local2
}
