import {combineReducers, compose, createStore} from "redux";
import cartReducer from "./slices/cartSlice";

/* store = {
		cart: [...],
		user: {...},
		theme: {...},
		...
	}
*/

const rootReducer = combineReducers({
	cart: cartReducer
})

const constructStore = () => {

	const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose

	return createStore(rootReducer, undefined, composeEnhancers())
}

export default constructStore
