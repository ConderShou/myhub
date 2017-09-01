
export class CounterService {

  private activeToInactive = 0;
	private inactiveToActive = 0;

	onActiveToInactive() {
		console.log("Active To Inactive: " + ++this.activeToInactive);
	}

	onInactiveToActive() {
		console.log("Inactive to Active " + ++this.inactiveToActive);
	}
}