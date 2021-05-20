import {FormControl, FormHelperText, InputLabel, OutlinedInput} from "@material-ui/core";
import {ErrorMessage, Field} from "formik";

const FormikInput = ({name, label, error, placeholder = "Type...", ...props}) => (
	<FormControl error={error} fullWidth variant="outlined" margin="dense">
		<InputLabel htmlFor={name}>{label}</InputLabel>
		<Field id={name} name={name} label={label}
			   placeholder={placeholder} {...props} as={OutlinedInput}/>
		<ErrorMessage name={name} component={FormHelperText}/>
	</FormControl>
)

export default FormikInput
