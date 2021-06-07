import {createSlice} from "@reduxjs/toolkit";

const initialState = {
	loggedInUser: null,
	jwt: null
}

const userSlice = createSlice({
	name: 'user',
	initialState,
	reducers: {
		login(user, { payload }) {
			return payload
		}
	}
})

export default userSlice.reducer
export const { login } = userSlice.actions
