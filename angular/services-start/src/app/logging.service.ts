
// A service is a normal TypeScript class 

export class LoggingService {

	//Now we simply use this service anywhere that it appears in our app
	logStatusChange(status: string) {
		console.log('A server status changed, new status: ' + status);
	}
}