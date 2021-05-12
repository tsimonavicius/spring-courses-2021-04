import React from "react";

export default class ItemUncontrolledComponent extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.name = React.createRef();
    }

    updateName(event) {
        console.log('Gavom ' + event.target.value)
    }

    setFocus() {
        this.name.current.focus();
    }

    render() {
        return (
            <>
                <div>
                    <input name="name"
                           type="text"
                           ref={this.name}
                           onChange={(event) => this.updateName(event)}/>
                    <button onClick={() => this.setFocus()}>Click Me!</button>
                </div>
            </>
        );
    }
}
