package com.airbnb.epoxy;

/** Used to register an onUnbind callback with a generated model. */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelUnboundListener#
//                                      ^ definition com/airbnb/epoxy/OnModelUnboundListener#[T]
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                               ^ definition com/airbnb/epoxy/OnModelUnboundListener#[V]
  /**
   * This will be called immediately after a model is unbound from a view, with the view and model
   * that were unbound.
   */
  void onModelUnbound(T model, V view);
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
//                    ^ reference com/airbnb/epoxy/OnModelUnboundListener#[T]
//                      ^^^^^ definition local0
//                             ^ reference com/airbnb/epoxy/OnModelUnboundListener#[V]
//                               ^^^^ definition local1
}
