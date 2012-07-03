package com.joilnen;

class GameState<T> { // Originator from Memento pattern
	T state;

	public GameState(T t) {
		state = t;
	}

	class Memento<T> {
		protected final T savedState;

		public Memento(T stateObject) {

			this.savedState = stateObject;

		}
	}
}


