import {combineReducers, createStore} from "redux";
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

	return createStore(rootReducer)
}

export default constructStore
