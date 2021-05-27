import { createSlice } from "@reduxjs/toolkit"
import {saveToLocalStorage} from "../../utils/localStorage";
import _ from "lodash"

const initialState = []

const cartSlice = createSlice({
	name: 'cart',
	initialState,
	reducers: {
		addToCart(cart, { payload: product }) {
			cart.push(product)
		},
		removeFromCart(state, action) {
			return state.filter((product) => product.id !== action.payload)
		}
	}
})

let prevCart = initialState

const subscribeToCartChanges = (store) => {
	store.subscribe(
		_.throttle(() => {
			const currentCart = store.getState().cart

			if (prevCart !== currentCart) {

				prevCart = currentCart
				saveToLocalStorage("cart", currentCart)
			}
	}, 1000))
}

export default cartSlice.reducer
export const { addToCart, removeFromCart } = cartSlice.actions
export { subscribeToCartChanges }
