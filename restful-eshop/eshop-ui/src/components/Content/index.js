import {Switch, Route} from "react-router-dom"
import LandingPage from "../../pages/LandingPage/LandingPage";
import NewProductPage from "../../pages/NewProductPage/NewProductPage";
import Product from "../../pages/Product/Product";
import Products from "../../pages/Products/Products";
import UserRegistration from "../UserRegistration/UserRegistration";
import CartPage from "../../pages/CartPage/CartPage";
import Login from "../../pages/Login/Login";
import Currency from "../../pages/Currency/Currency";
import {createMuiTheme, MuiThemeProvider} from "@material-ui/core";
import {green, pink} from "@material-ui/core/colors";
import Users from "../../pages/Users/Users";
import SecuredRoute from "../SecuredRoute/SecuredRoute";

export default () => {
    const theme = createMuiTheme({
        palette:{
            primary: {main: green[300]},
            secondary: {main: pink[200]}
        }
    });

    return (
        <>
            <Switch>
                <Route exact path="/">
                    <LandingPage/>
                </Route>
                <Route exact path="/products">
                    <MuiThemeProvider theme={theme}>
                        <Products/>
                    </MuiThemeProvider>
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
                <SecuredRoute path="/users" roles={["ADMIN"]}>
                    <Users/>
                </SecuredRoute>
            </Switch>
        </>
    )
};
