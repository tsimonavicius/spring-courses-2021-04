import {Switch, Route} from "react-router-dom"
import LandingPage from "../../pages/LandingPage/LandingPage";
import NewProductPage from "../../pages/NewProductPage/NewProductPage";

export default () => (
	<>
		<Switch>
			<Route exact path="/">
				<LandingPage/>
			</Route>
			<Route path="/products/new">
				<NewProductPage/>
			</Route>
		</Switch>
	</>
)
