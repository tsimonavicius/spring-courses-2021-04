import {useTranslation} from "react-i18next";
import {MenuItem, Select} from "@material-ui/core";

export default () => {
    const {i18n} = useTranslation();

    const onChangeLanguage = (e) => {
        i18n.changeLanguage(e.target.value);
    }

    return (
        <Select
            labelId="language-switcher-label"
            value={i18n.language}
            onChange={onChangeLanguage}
        >
            <MenuItem value={'lt'}>LT</MenuItem>
            <MenuItem value={'en'}>EN</MenuItem>
            <MenuItem value={'de'}>DE</MenuItem>
        </Select>
    );
}
