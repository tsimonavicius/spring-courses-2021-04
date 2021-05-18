import React from "react";
import ItemBadge from "./ItemBadge";
import ItemText from "./ItemText";
import "../../../styles/ItemActionStyles.css";
import {Button, TextField} from "@material-ui/core";
import {styled} from "@material-ui/styles";

const DeleteButton = styled(Button)({
    background: 'linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)',
    border: 0,
    borderRadius: 3,
    boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
    color: 'white',
    height: 48,
    padding: '0 30px',
});

export default class Item extends React.Component {

    render() {
        return (
            <>
                <div className="col-5">
                    <div className="input-group col-sm-6">
                        <ItemBadge quantity={this.props.item.quantity}/>
                        <TextField id="outlined-basic"
                                   label="Description"
                                   variant="outlined"
                                   onChange={(event) => this.props.onHandlingItemText(event, this.props.item.id)}/>
                        <Button className="addButton"
                                onClick={() => this.props.onHandlingAddQuantity(this.props.item)}>+</Button>
                        <Button className="removeButton"
                                onClick={() => this.props.onHandlingRemoveQuantity(this.props.item)}>-</Button>
                        <DeleteButton onClick={() => this.props.onHandlingDeleteItem(this.props.item.id)}>Delete</DeleteButton>
                    </div>
                    {
                        this.props.item.isItemTextVisible && <ItemText item={this.props.item}
                                  onHandlingHideText={this.props.onHandlingHideText}/>
                    }
                </div>
            </>
        );
    }
}
