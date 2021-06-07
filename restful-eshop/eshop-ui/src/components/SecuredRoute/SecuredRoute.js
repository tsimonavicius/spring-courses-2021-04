import {Redirect, Route, useLocation} from "react-router-dom";
import {useSelector} from "react-redux";
import _ from 'lodash'

const SecuredRoute = ({roles, ...props}) => {

	const location = useLocation()

	const userRoles = useSelector(state => state.user.loggedInUser?.roles)
	const authorized = !!_.intersection(userRoles, roles).length

	return authorized ?
		<Route {...props} /> :
		<Redirect to={{
			pathname: '/login',
			state: {
				from: location
			}
		}}/>

}

export default SecuredRoute
