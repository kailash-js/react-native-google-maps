//
//  KLGoogleMapsViewManager.swift
//  KLGoogleMaps
//
//  Created by Long Cao on 1/19/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import UIKit

@objc(KLGoogleMapsViewManager)
class KLGoogleMapsViewManager: RCTViewManager {
  
  @objc static override func requiresMainQueueSetup() -> Bool {
    return true
  }
  
  override func view() -> UIView! {
    return KLGoogleMapsView()
  }      
}

