import {Trans} from "react-i18next";

const LandingPage = () => {

	return (
		<>
			<Trans
				i18nKey="Key with param2"
				defaults="This is default value"
				values={{name:'Andrius', surname: 'Baltrunas'}}
			/>
		</>
	)
}

export default LandingPage;
