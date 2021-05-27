import cart, {loadCartFromLocalStorage, subscribeToCartChanges} from "./slices/cartSlice";
import {configureStore} from "@reduxjs/toolkit";
import {logger} from "redux-logger/src";

/* store = {
		cart: [...],
		user: {...},
		theme: {...},
		...
	}
*/

const constructStore = () => {

	const store = configureStore({
		reducer: {
			cart
		},
		middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
		preloadedState: {
			cart: loadCartFromLocalStorage()
		}
	})

	subscribeToCartChanges(store)

	return store
}

export default constructStore
