import {withTranslation} from "react-i18next";

const LandingPage = ({t, i18n}) => {

	return (
		<>
			<h1>Hello!</h1>
			<div>{t('Welcome to key not found')}</div>
			<div>{t('Key with param', {name: 'Andrius', surname: 'Baltrunas'})}</div>
			<div>{t('second:Key', {count: 0})}</div>
			<div>{t('products:Key2')}</div>
		</>
	)
}

export default withTranslation()(LandingPage);
