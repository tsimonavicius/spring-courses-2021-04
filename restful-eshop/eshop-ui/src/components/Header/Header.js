import AppBar from "@material-ui/core/AppBar";
import {Badge, Box, Toolbar} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import Button from "@material-ui/core/Button";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import {Link as RouterLink, NavLink} from "react-router-dom";
import {useSelector} from "react-redux";
import LanguageSwitcher from "../translation/LanguageSwitcher";
import {useTranslation} from "react-i18next";

const useStyles = makeStyles((theme) => ({
	appBar: {
		borderBottom: `1px solid ${theme.palette.divider}`,
	},
	toolbarTitle: {
		flexGrow: 1,
	},
	link: {
		margin: theme.spacing(1, 1.5),
	},
	toolbar: {
		flexWrap: 'wrap',
	},
	active: {
		fontWeight: "bolder",
		color: "blue"
	}
}))

export default () => {
	const {t} = useTranslation('header');

	const classes = useStyles()

	const numberOfCartItems = useSelector(state => state.cart.length)
	const userFullName = useSelector(state => state.user.loggedInUser?.fullName)

	return (
		<>
			<AppBar position="static" color="default" elevation={0} className={classes.appBar}>
				<Toolbar className={classes.toolbar}>
					<Typography variant="h6" color="inherit" noWrap className={classes.toolbarTitle}>
						Eshop
					</Typography>
					<nav>
						<Link variant="button" color="textPrimary" to="/products"
							  className={classes.link} activeClassName={classes.active} component={NavLink}>
							{t('products')}
						</Link>
						<Link variant="button" color="textPrimary" href="#" className={classes.link}>
							{t('users')}
						</Link>
						<Link variant="button" color="textPrimary" to="/currencies"
							  className={classes.link} activeClassName={classes.active} component={NavLink}>
							{t('currencies')}
						</Link>
						<Badge badgeContent={numberOfCartItems} color="secondary" showZero>
							<Link variant="button" color="textPrimary" to="/cart"
								  className={classes.link} activeClassName={classes.active} component={NavLink}>
								{t('cart')}
							</Link>
						</Badge>
					</nav>
					<Box mx={4}>
						{userFullName ?
							<>
								<Typography variant="h6" component="span">
									Sveiki, {userFullName}
								</Typography>
								<Button color="secondary" variant="contained" className={classes.link}>
									Logout
								</Button>
							</>
							 :
							<>
								<Button color="primary" to="/login" variant="contained" component={RouterLink}>
									Login
								</Button>
								<Button href="#" color="secondary" variant="contained" className={classes.link}>
									{t('signIn')}
								</Button>
							</>
						}
					</Box>
					<LanguageSwitcher/>
				</Toolbar>
			</AppBar>
		</>
	)
}
