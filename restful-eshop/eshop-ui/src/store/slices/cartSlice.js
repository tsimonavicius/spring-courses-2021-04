const ADD_TO_CART = "ADD_TO_CART"
const REMOVE_FROM_CART = "REMOVE_FROM_CART"

const cartReducer = (state = [], action) => {

	switch (action.type) {
		case ADD_TO_CART:
			return [...state, action.product]
		case REMOVE_FROM_CART:
			return state.filter((product) => product.id !== action.productId)
		default:
			return state
	}
}

const addToCart = (product) => ({
	type: ADD_TO_CART,
	product
})

const removeFromCart = (productId) => ({
	type: REMOVE_FROM_CART,
	productId
})

export default cartReducer
export { addToCart, removeFromCart }
