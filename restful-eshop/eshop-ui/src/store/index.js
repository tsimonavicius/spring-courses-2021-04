import cart from "./slices/cartSlice";
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

	return configureStore({
		reducer: {
			cart
		},
		middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger)
	})
}

export default constructStore
