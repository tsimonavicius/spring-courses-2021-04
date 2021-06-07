import cart, {loadCartFromLocalStorage, subscribeToCartChanges} from "./slices/cartSlice";
import {configureStore} from "@reduxjs/toolkit";
import {logger} from "redux-logger/src";
import user from './slices/userSlice'

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
			cart,
			user
		},
		middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
		preloadedState: {
			cart: loadCartFromLocalStorage()
		}
	})

	subscribeToCartChanges(store)

	return store
}

const store = constructStore()

export default store
