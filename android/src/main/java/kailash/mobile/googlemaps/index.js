import React,{useRef, useEffect} from 'react';
import { NativeModules, requireNativeComponent, View, UIManager,
  findNodeHandle, Platform } from 'react-native';

  const COMPONENT_NAME = 'KLGoogleMapsView';

const settings = {
    name: COMPONENT_NAME,
    propTypes: {
      ...View.propTypes,
    },
  };

const KLGoogleMapsView = requireNativeComponent(COMPONENT_NAME, settings);

const { KLGoogleMaps } = NativeModules;

export default KLGoogleMaps;
export {KLGoogleMapsView}

export const GoogleMapsView = (props) => {
  const googleMapsViewRef = useRef(null);

  const _getHandle =() => {
    return findNodeHandle(googleMapsViewRef.current);
  }

  const _runCommand = (name, args) => {
    switch (Platform.OS) {
      case 'android':
        return UIManager.dispatchViewManagerCommand(
          findNodeHandle(googleMapsViewRef.current),
          name,
          args);

      case 'ios':
        return UIManager.dispatchViewManagerCommand(
          findNodeHandle(googleMapsViewRef.current),
          UIManager.getViewManagerConfig(COMPONENT_NAME).Commands[name],
          args); 

      default:
        return Promise.reject(`Invalid platform was passed: ${Platform.OS}`);
    }

      
  }

  const doLoadMarker = () => {    
    _runCommand('loadMarker',[{name: 'love',list:[{n: 1},{n: 2}]}]);      
  };

  useEffect(()=>{
    setTimeout(()=>{
      doLoadMarker();
    }, 2000)
  },[])
  return (
    <KLGoogleMapsView ref={googleMapsViewRef} {...props}/>
  )
}