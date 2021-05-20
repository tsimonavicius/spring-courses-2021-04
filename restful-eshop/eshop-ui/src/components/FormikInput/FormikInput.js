import {FormControl, FormHelperText, Input, InputLabel} from "@material-ui/core";
import {ErrorMessage, Field} from "formik";

const FormikInput = ({ name, label, error, placeholder = "Type...", ...props }) => (
	<FormControl error={error}>
		<InputLabel htmlFor={name}>{label}</InputLabel>
		<Field id={name} name={name} placeholder={placeholder} {...props} as={Input}/>
		<ErrorMessage name={name} component={FormHelperText}/>
	</FormControl>
)

export default FormikInput
