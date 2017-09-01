import { AnAppPage } from './app.po';

describe('an-app App', () => {
  let page: AnAppPage;

  beforeEach(() => {
    page = new AnAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
