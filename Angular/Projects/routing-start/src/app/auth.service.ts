//A fake service for Auth.
// This normally reaches out to a server of some kind - more on this later

export class AuthService {

	loggedIn = false;

	//Faking a server
	isAuthenticated() {
		const promise = new Promise(
			(resolve, reject) => {
				setTimeout(() => {
					resolve(this.loggedIn)
				}, 800);
			}
		);

		return promise; 
	}

	login() {
		this.loggedIn = true;
	}

	logout() {
		this.loggedIn = false;
	}

}