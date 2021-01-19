import { NativeModules, requireNativeComponent, View } from 'react-native';

const settings = {
    name: 'KLGoogleMapsView',
    propTypes: {
      ...View.propTypes,
    },
  };

const KLGoogleMapsView = requireNativeComponent('KLGoogleMapsView', settings);

const { KLGoogleMaps } = NativeModules;

export default KLGoogleMaps;
export {KLGoogleMapsView}