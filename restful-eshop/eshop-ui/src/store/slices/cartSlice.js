import { createSlice } from "@reduxjs/toolkit"
import {saveToLocalStorage} from "../../utils/localStorage";

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
	const currentCart = store.getState().cart

	if (prevCart !== currentCart) {

		prevCart = currentCart
		store.subscribe(() => {
			saveToLocalStorage("cart", currentCart)
		})
	}
}

export default cartSlice.reducer
export const { addToCart, removeFromCart } = cartSlice.actions
export { subscribeToCartChanges }
