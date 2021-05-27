import { createSlice } from "@reduxjs/toolkit"

const cartSlice = createSlice({
	name: 'cart',
	initialState: [],
	reducers: {
		addToCart(cart, { payload: product }) {
			cart.push(product)
		},
		removeFromCart(state, action) {
			return state.filter((product) => product.id !== action.payload)
		}
	}
})

export default cartSlice.reducer
export const { addToCart, removeFromCart } = cartSlice.actions
