import Container from "@material-ui/core/Container";
import Typography from "@material-ui/core/Typography";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import Link from "@material-ui/core/Link";

function Copyright() {
	return (
		<Typography variant="body2" color="textSecondary">
			{'Copyright © '}
			<Link color="inherit" href="https://material-ui.com/">
				Your Website
			</Link>{' '}
			{new Date().getFullYear()}
			{'.'}
		</Typography>
	);
}

const useStyles = makeStyles((theme) => ({
	footer: {
		padding: theme.spacing(3, 2),
		marginTop: 'auto',
		backgroundColor:
			theme.palette.type === 'light' ? theme.palette.grey[200] : theme.palette.grey[800],
	}
}));

export default () => {
	const classes = useStyles();

	return (
		<footer className={classes.footer}>
			<Container maxWidth="sm">
				<Typography variant="body1">Eshop Footer</Typography>
				<Copyright/>
			</Container>
		</footer>
	)
}
