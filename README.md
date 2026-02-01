[feat] Implement Spring Bean scopes and lifecycle (init/destroy)

- Created Shape interface implementations: Circle and Square
- Added Draw2D and Draw3D helper classes
- Injected Draw2D/Draw3D into shapes
    - Constructor injection for Circle
    - Setter injection for Square
- Configured bean scopes:
    - Circle as singleton
    - Square as prototype
- Retrieved and used Circle and Square beans in main application

- Added DatabaseOperations bean
- Implemented bean lifecycle methods:
    - connectToDatabase() as init-method
    - disconnectFromDatabase() as destroy-method
- Configured init and destroy methods in Spring XML
- Verified lifecycle behavior by starting and closing Spring container
