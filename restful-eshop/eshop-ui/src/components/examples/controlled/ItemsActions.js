import React from "react";
import {Button} from "@material-ui/core";

export default class ItemsActions extends React.Component {

    render() {
        return (
            <div>
                <Button variant="contained"
                        color="primary"
                        onClick={() => this.props.onHandlingAddItem()}>Add</Button>
                <Button variant="contained"
                        color="secondary"
                        onClick={() => this.props.onHandlingResetQuantity()}>Reset</Button>
            </div>
        );
    }
}
