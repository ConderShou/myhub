
// We have to make sure this action is wired up to redux when we use it in a component
// NOTE: in other words, this wiring occurs in the component, not in this file

export function selectBook(book) {
   
    // Because this is an ActionCreator, it needs to return an Action

    // An Action is an object with a TYPE property
    // It usually has TWO values: A TYPE and a PAYLOAD
    //   - The payload contains further information associated with the action - the data (another 'condition')
                // The payload isn't required for an action to be deemed acceptable

    //   - The type is MANDATORY.
    //          - Must describe the PURPOSE of the action

    return {

        //The type can be seen as a variable and not a string sometimes, we will go through this later
            // - The 100% right way is to pull the names out and into a file so that the naming always remains consistent
            
         type: 'BOOK_SELECTED',
         payload: book
    }
}