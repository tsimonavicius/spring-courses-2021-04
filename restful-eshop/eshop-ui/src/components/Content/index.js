import {Switch, Route} from "react-router-dom"
import LandingPage from "../../pages/LandingPage/LandingPage";

export default () => (
	<>
		<Switch>
			<Route path="/">
				<LandingPage/>
			</Route>
		</Switch>
	</>
)
