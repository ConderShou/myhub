//
//  ViewController.swift
//  PageScroll
//
//  Created by Admin on 2/18/17.
//  Copyright © 2017 Admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var scrollView: UIScrollView!
    var images = [UIImageView]()    //an array of images of type UIImageView
                                    //Needs to be a VAR in order to let us change it
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //print("Scrollview width: \(scrollView.size.width)")
        //RETURNS ZERO
        //Can't guarantee in VIEWDIDLOAD that you have access to the width and dimensions of other views
        //We're going to move a bunch of content into VIEWDIDAPPEAR where the information WILL be available
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        
        //print("Scrollview width: \(scrollView.size.width)")
        //NOW we get the ACTUAL width of the ScrollView
        //Now we can fix the sccrolling area IN RESPECT the the SCROLL VIEW
        
        
        //Content size must be as large as the SCROLLVIEW in order for the view to scroll
        //The content size is what is SCROLLABLE - INCLUDING what's OFF SCREEN
        var contentWidth: CGFloat = 0.0
        let scrollWidth = scrollView.frame.size.width
        
        for x in 0...2 {
            let image = UIImage(named: "icon\(x).png")  //Manipulating display by using the systematic names of the files and the for loop
            let imageView = UIImageView(image: image)
            images.append(imageView)     //Adding the imageview on to the array of images
            
            var newX: CGFloat = 0.0
            
            newX = scrollWidth / 2 + scrollWidth * CGFloat(x)
            
            //!!!!!!!
            //BUT NOW WE'VE CHANGED IT TO 'scrollView.frame.width / 2' to put it in RESPECT to SCROLLVIEW
            //!!!!!!!
            
            //!!!!!
            //BELOW WAS FOR THE VIEWCONTROLLER ITSELF
            //
            //view.frame = the frame of the VIEW
            //midX = the middle X coordinate of the view
            //view.frame.size.width = the WIDTH of the whole view
            //x here is the index
            
            //view.frame.midX ensures that the icon is in the middle
            // but then we ADD the size of the view multiplied by the index
            //      This means the first icon is added with 0. Kept  in the middle
            //      Second icon is a full screen away (added the screen width * 1)
            //      Third icon is two full screens away
            //      etc...
            //!!!!!!
            
            //You may have to write code to detect which screen sizes are being used and which works best (??)
            
            //The entire width of the horizontal display of the icons must be put into the 'contentWidth' in order to be considered SCROLLABLE
            //This width is still CONTAINED within ScrollView - doesn't mean the width PAST the bounds of the ScrollView will also be scrollable
            contentWidth += newX
            
            scrollView.addSubview(imageView)
            
            //We set frame on the image AFTER it has been added as a subview to the ScrollView
            imageView.frame = CGRect(x: newX - 75, y: (scrollView.frame.size.height / 2) - 75, width: 150, height: 150) //We determine the width and height by just TESTING and seeing which works best
            
            //Like all images in XCode, the coordinates of the image start at the TOP LEFT. So the icons TOP edge are placed in the middle of the screen, rather than the middle of the icon itself
            //We shall now subtract HALF the HEIGHT of the image in order to compensate for this (75)
            //      Remember, the TOP LEFT of the view is 0,0. So subtracting brings the icon UP
            //      We do same for the 'x' position - where the left edge is considered to be in the middle. We subtract HALF the WIDTH of the image
        }
        
        //Telling ScrollView NOT to hide the icons that are OUT OF ITS BOUNDS
        //We want to see the EDGES of the next icons on the side
        scrollView.clipsToBounds = false
        //If this doesn't work still, just make the view width SMALLER
        
        //Making things scrollable now
        scrollView.contentSize = CGSize(width: contentWidth, height: view.frame.size.height)
        
        
        //NEXT STEP: Figuring out how to allow the user to scroll beyond the borders of scroll view
    }

}

