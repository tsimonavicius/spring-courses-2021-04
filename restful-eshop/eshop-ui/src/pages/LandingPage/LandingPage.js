import {Translation} from "react-i18next";
import i18n from "i18next";

const LandingPage = () => {

	return (
		<>
			<Translation>
				{(t, {i18n}) =>
					<>
						<h1>Hello!</h1>
						<div>{t('Welcome to key not found')}</div>
						<div>{t('Key with param', {name: 'Andrius', surname: 'Baltrunas'})}</div>
						<div>{t('second:Key', {count: 0})}</div>
						<div>{t('products:Key2')}</div>
					</>
				}
			</Translation>
		</>
	)
};

export default LandingPage;
