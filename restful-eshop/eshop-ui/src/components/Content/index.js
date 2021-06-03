import {Switch, Route} from "react-router-dom"
import LandingPage from "../../pages/LandingPage/LandingPage";
import NewProductPage from "../../pages/NewProductPage/NewProductPage";
import Product from "../../pages/Product/Product";
import Products from "../../pages/Products/Products";
import UserRegistration from "../UserRegistration/UserRegistration";
import CartPage from "../../pages/CartPage/CartPage";
import Login from "../../pages/Login/Login";
import Currency from "../../pages/Currency/Currency";

export default () => (
	<>
		<Switch>
			<Route exact path="/">
				<LandingPage/>
			</Route>
			<Route exact path="/products">
				<Products/>
			</Route>
			<Route path="/products/new">
				<NewProductPage/>
			</Route>
			<Route path="/products/:productId">
				<Product/>
			</Route>
			<Route path="/signup">
				<UserRegistration/>
			</Route>
			<Route path="/cart">
				<CartPage/>
			</Route>
			<Route path="/login">
				<Login/>
			</Route>
			<Route path="/currencies">
				<Currency/>
			</Route>
		</Switch>
	</>
)
