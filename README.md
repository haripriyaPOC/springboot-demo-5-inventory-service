# inventory-service

Sample inventory API with stock quantities

## Requirements
- Java 17
- Maven 3.9+ (optional if using Docker build)
- Docker (for container build)
- Kubernetes and kubectl (for Kubernetes deployment)

## Run locally
```bash
mvn spring-boot:run

```

Test the API:
```bash
curl http://localhost:8080/api/inventory
curl http://localhost:8080/actuator/health
```

## Build a JAR
```bash
mvn clean package
java -jar target/inventory-service-0.0.1-SNAPSHOT.jar
```

## Build and run with Docker
```bash
docker build -t inventory-service:1.0.0 .
docker run --rm -p 8080:8080 inventory-service:1.0.0
```

Then test `http://localhost:8080/api/inventory`.

## Deploy to Kubernetes
1. Update the image in `k8s/deployment.yaml` to the image you pushed to your registry.
2. Push the image to your registry, for example:
   ```bash
   docker tag inventory-service:1.0.0 YOUR_REGISTRY/inventory-service:1.0.0
   docker push YOUR_REGISTRY/inventory-service:1.0.0
   ```
3. Apply the manifests:
   ```bash
   kubectl apply -f k8s/
   kubectl rollout status deployment/inventory-service
   kubectl get pods,svc -l app=inventory-service
   ```
4. Test from inside the cluster or port-forward:
   ```bash
   kubectl port-forward svc/inventory-service 8080:80
   curl http://localhost:8080/api/inventory
   ```

## Health checks
- `/actuator/health`
- `/actuator/health/readiness`
- `/actuator/health/liveness`

These are demo applications with in-memory/static data only; no database is required.
