import {FormControl, FormHelperText, FormLabel, InputLabel, OutlinedInput} from "@material-ui/core";
import {ErrorMessage, Field} from "formik";

const FormikInput = ({name, label, error, placeholder = "Type...", ...props}) => (
	<FormControl error={error} fullWidth variant="outlined" margin="dense">
		<FormLabel htmlFor={name}>{label}</FormLabel>
		<Field id={name} name={name} placeholder={placeholder} {...props} as={OutlinedInput}/>
		<ErrorMessage name={name} component={FormHelperText}/>
	</FormControl>
)

export default FormikInput
