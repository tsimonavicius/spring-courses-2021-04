import React from "react";

export default class ItemsActions extends React.Component {

    render() {
        return (
            <div>
                <button className="btn btn-outline-success"
                        type="button"
                        onClick={() => this.props.onHandlingAddItem()}>Add
                </button>
                <button className="btn btn-outline-info"
                        type="button"
                        onClick={() => this.props.onHandlingResetQuantity()}>Reset
                </button>
            </div>
        );
    }
}
