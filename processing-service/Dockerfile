FROM golang:1.19-alpine
WORKDIR /app
ENV GO111MODULE on
ENV CGO_ENABLED 0
ENV GOOS linux
ENV GOARCH amd64
ENV CGO 0
RUN apk add --no-cache gcc musl-dev
COPY . .
RUN go mod download
RUN go build -o ./run
ENTRYPOINT ["./run"]