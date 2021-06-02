import {useTranslation} from "react-i18next";

const LandingPage = () => {
	const {t} = useTranslation();

	return (
		<>
			<h1>Hello!</h1>
			{t('Welcome to key not found')}
		</>
	)
}

export default LandingPage
