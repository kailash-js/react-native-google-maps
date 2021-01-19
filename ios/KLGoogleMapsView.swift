//
//  KLGoogleMapsView.swift
//  KLGoogleMaps
//
//  Created by Long Cao on 1/19/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import GoogleMaps

@objc(KLGoogleMapsView)
class KLGoogleMapsView: UIView {
      
  var mapView : GMSMapView?;
    
  override init(frame: CGRect) {
    super.init(frame: frame)
    let camera = GMSCameraPosition.camera(withLatitude: -33.86, longitude: 151.20, zoom: 6.0)
    self.mapView = GMSMapView.map(withFrame: self.frame, camera: camera)
    self.addSubview(mapView!)
  }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        self.mapView!.frame = self.frame
    }
  
    @objc
     func loadMarker(_ camera: NSDictionary) {
        print(camera)
       for _ in 1...1000 {
           let marker = GMSMarker()
           marker.position = CLLocationCoordinate2D(latitude: Double.random(in: (-35.86)...(-30.86)), longitude: Double.random(in: 111.20...151.20))
           marker.title = "Sydney"
           marker.snippet = "Australia"
           marker.map = self.mapView
       }
        let fancy = GMSCameraPosition.camera(
          withLatitude: -33,
          longitude: 151,
          zoom: 6,
          bearing: 270,
          viewingAngle: 45
        )
        self.mapView?.camera = fancy
     }
    
  required init?(coder aDecoder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }

}
