import AppBar from "@material-ui/core/AppBar";
import {Toolbar} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import Button from "@material-ui/core/Button";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import {NavLink} from "react-router-dom";

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
	const classes = useStyles()
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
							Products
						</Link>
						<Link variant="button" color="textPrimary" href="#" className={classes.link}>
							Users
						</Link>
					</nav>
					<Button href="#" color="primary" variant="outlined" className={classes.link}>
						Login
					</Button>
				</Toolbar>
			</AppBar>
		</>
	)
}
