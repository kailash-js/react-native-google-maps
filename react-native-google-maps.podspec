require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-google-maps"
  s.version      = package["version"]
  s.summary      = package["description"] 
  s.homepage     = "https://github.com/github_account/react-native-google-maps"  
  s.license      = "MIT"  
  # s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = { "Your Name" => "ltcaosj@email.com" }
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/kailash-js/react-native-google-maps.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,c,m,swift}"  
  s.dependency "React"
  s.dependency "GoogleMaps", "4.1.0"
  # ...
  # s.dependency "..."
end

