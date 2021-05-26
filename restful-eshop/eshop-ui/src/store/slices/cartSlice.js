const ADD_TO_CART = "ADD_TO_CART"

const cartReducer = (state = [], action) => {

	switch (action.type) {
		case ADD_TO_CART:
			return [...state, action.product]
		default:
			return state
	}
}

const addToCart = (product) => ({
	type: ADD_TO_CART,
	product
})

export default cartReducer
export { addToCart }
